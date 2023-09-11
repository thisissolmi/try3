package com.mycom.word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    ArrayList<Word> list;
    Scanner s;
    final String fname = "Dictionary.txt";

    //final Stirng fname = "Dictionary.txt";
    /*
     * => 난이도 (1,2,3) & 새 단어 입력 : 1 driveway
     * 뜻 력 : 차고 진입로
     * 새 단어가 단어장 추가되었습니다.
     * */

    WordCRUD(Scanner s) {
        list = new ArrayList<>();
        this.s = s;
    }

    @Override

    public Object add() { //추가하기
        System.out.print("\n=> 난이도 (1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String word = s.nextLine();
        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();
        return new Word(0, level, word, meaning);
    }


    public void addItem() { //추가하기
        Word one = (Word) add();
        list.add(one);
        System.out.println("\n새 단어가 단어장 추가되었습니다. \n");

    }

    @Override
    public int update(Object obj) { //업데이트하기
        return 0;
    }

    @Override
    public int delete(Object obj) { //삭제하기
        return 0;
    }

    @Override
    public int selectOne(int id) { //선택하기
        return 0;
    }

    public ArrayList<Integer> listAll(String keyword) { //ArrayList를 사용하여 리스트 뽑기
        ArrayList<Integer> idlist = new ArrayList<>();
        int j = 0;
        System.out.println("\n\n--------------------------");
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i).getWord();
            if (!word.contains(keyword)) continue;
            System.out.print((j + 1) + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("--------------------------\n\n");
        return idlist;

    }

    public void listAll() { //리스트 모두 뽑기
        System.out.println("\n\n--------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------\n\n");

    }

    public void updateItem() { //아이템(단어) 업데이트 하기
        System.out.print("=> 수정할 단어 검색 : ");
        String keyword = s.next(); //s.next는 공백을 허용하지 않게 하기 위하여 사용
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 수정할 번호 검색 : ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("=> 뜻 입력 : ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id - 1));
        word.setMeaning(meaning);
        System.out.println("단어가 수정되었습니다. ");
    }

    public void deleteItem() { //아이템(단어) 삭제하기
        System.out.print("=> 삭제 할 단어 검색 : ");
        String keyword = s.next(); //s.next는 공백을 허용하지 않게 하기 위하여 사용
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 삭제 할 번호 검색 : ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("=> 정말로 삭제하실래요? (Y/n) ");
        String ans = s.next();
        if (ans.equalsIgnoreCase("y")) {
            list.remove((int) idlist.get(id - 1));
            System.out.println("단어가 샥제 되었습니다. ");
        } else
            System.out.println("취소 되었습니다. ");


    }

    public void loadFile() { //.txt 파일로부터 정보를 불러오는 것
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count = 0;

            while (true) {
                line = br.readLine();
                if (line == null) break;

                String data[] = line.split("\\|"); // 앞에 \\를 넣어줘야해
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                list.add(new Word(0, level, word, meaning));
                count++;
            }
            br.close();
            System.out.println("==>" + count + "개 로딩 완료~!~!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

