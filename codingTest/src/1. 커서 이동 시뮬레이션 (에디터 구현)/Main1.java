import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();  // 추가: 버퍼에 남아있는 줄바꿈 문자 처리
        // sc.nextLine();을 추가로 써주지 않으면 nextInt()가 줄바꿈인 엔터를 인식하지 못해서 command 한번을 엔터로 사용함. 이를 nextLine() 버그라고 함.

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char ch : str.toCharArray()) {
            left.push(ch);
        }

        for (int i=0; i<n; i++) {
            System.out.println(i);
            String command = sc.nextLine();

            if (command.startsWith("L") && !left.isEmpty()) {  // Startswith() : 해당 문자로 시작하는지 확인, bool 타입으로 반환
                right.push(left.pop());
            } else if (command.startsWith("D") && !right.isEmpty()) {
                left.push(right.pop());
            } else if (command.startsWith("B") && !left.isEmpty()) {
                left.pop();
            } else if (command.startsWith("P")) {
                left.push(command.split(" ")[1].charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!left.isEmpty()) {
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}