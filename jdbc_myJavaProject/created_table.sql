--�������� java fx

--1.å��� ���̺�(å��ȣ(PK), å�̸�, å�̹���)
CREATE TABLE booklist(
	num NUMBER(15) PRIMARY KEY,
	book_name VARCHAR2(20) NOT NULL,
	book_img VARCHAR2(20)
);
--2.ȸ������ ���̺�(ȸ����ȣ(PK), ȸ�����̵�(UNIQUE), ��й�ȣ, �̸�, �ּ�, �̸���, ĳ���ܾ�, ���Գ�¥) 
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
--3.å���ݹ� �������̺�(å��ȣ(FK), å����, å�帣)
CREATE TABLE booktype(
	num NUMBER(15) REFERENCES booklist(num),
	book_price NUMBER(20) NOT NULL,
	book_type VARCHAR(15)
);
--4.å ����� �Ǹ� ���� ���̺�(å��ȣ(FK), �����ִ� �������, ������� �Ǹŵ� ����)
CREATE TABLE stocksale(
	num NUMBER(15) REFERENCES booklist(num),
	stock_cnt NUMBER(15),
	sell_cnt NUMBER(15)
);

--������ (ȸ������)
CREATE SEQUENCE addUser_seq;

--������ (å��� & å���)
CREATE SEQUENCE booklist_seq;
