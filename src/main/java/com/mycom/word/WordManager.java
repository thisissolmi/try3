package com.mycom.word;
//import com.mycom.word.WordCRUD;

import java.util.Scanner;

public class WordManager {
    Scanner s = new Scanner(System.in);//멤버변수 추가
    WordCRUD wordCRUD;

    WordManager(){
        wordCRUD = new WordCRUD(s);
    }

    public int selectMenu() {
        System.out.print(
                "***영단어마스터***\n"
                        + "***************\n"
                        + "1.모든 단어 보기 \n"
                        + "2.수준별 단어보기 \n"
                        + "3.단어 검색\n"
                        + "4.단어 추가\n"
                        + "5.단어 수정\n"
                        + "6.단어 삭제\n"
                        + "7.파일 저장\n"
                        + "0.나가기\n"
                        + "***************\n"
                        + "=> 원하는 메뉴는? ");

        return s.nextInt();

    }

    public void start() {
        
        wordCRUD.loadFile();
        while(true) {
            int menu = selectMenu();
            if(menu == 0){// 종료
                System.out.println("프로그램 종료! 다음에 만나요~");
                break;
            }
            if(menu == 4) { //단어 추가
                wordCRUD.addItem();
            }
            else if(menu == 1) { //list 보여주기
                wordCRUD.listAll();
            }
            else if(menu == 5 ) { //update
                wordCRUD.updateItem();
            }
            else if(menu == 6 ) { // delete
                wordCRUD.deleteItem();

            }

        }

    }
}
