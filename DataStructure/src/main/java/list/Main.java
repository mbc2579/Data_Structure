package list;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 문자열 리스트 생성
        List<String> list = new ArrayList<>();

        // 리스트에 문자열 넣기
        list.add("Hello");
        list.add("World");
        list.add("GRACE");

        System.out.println(list);

        // 리스트에서 문자열 삭제
        list.remove("Hello");

        System.out.println(list);

        // 리스트에서 원하는 문자열 찾기 (0번째 데이터)
        System.out.println(list.get(0));
    }
}