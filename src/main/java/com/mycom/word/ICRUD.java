package com.mycom.word;// 이 패키지를 왜 사용해야하는지 알기

public interface ICRUD {
    public Object add(); //추가 한 해당하는 객체를 리턴하려고 오브젝트 타입을 넣어줌
    public int update(Object obj); //수정 업데이트
    public int delete(Object obj); //삭제 리스트
    public void selectOne(int id); //하나 조회하는 걸 출력할 수 있도록
}
