--도서관리 java fx

--1.책목록 테이블(책번호(PK), 책이름, 책이미지)
CREATE TABLE booklist(
	num NUMBER(15) PRIMARY KEY,
	book_name VARCHAR2(20) NOT NULL,
	book_img VARCHAR2(20)
);
--2.회원정보 테이블(회원번호(PK), 회원아이디(UNIQUE), 비밀번호, 이름, 주소, 이메일, 캐시잔액, 가입날짜) 
CREATE TABLE join_users(
	jnum NUMBER(15) PRIMARY KEY,
	id VARCHAR2(15) UNIQUE NOT NULL,
	pw VARCHAR2(15) NOT NULL,
	name VARCHAR2(10) NOT NULL,
	addr VARCHAR2(20) NOT NULL,
	email VARCHAR2(20),
	cash NUMBER(20),
	join_date DATE
);
--3.책가격및 종류테이블(책번호(FK), 책가격, 책장르)
CREATE TABLE booktype(
	num NUMBER(15) REFERENCES booklist(num),
	book_price NUMBER(20) NOT NULL,
	book_type VARCHAR(15)
);
--4.책 재고및 판매 관련 테이블(책번호(FK), 남아있는 재고수량, 현재까지 판매된 수량)
CREATE TABLE stocksale(
	num NUMBER(15) REFERENCES booklist(num),
	stock_cnt NUMBER(15),
	sell_cnt NUMBER(15)
);

--스퀸스 (회원가입)
CREATE SEQUENCE addUser_seq;

--스퀸스 (책목록 & 책등록)
CREATE SEQUENCE booklist_seq;

