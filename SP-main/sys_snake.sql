select * from dba_tablespaces;

SELECT USERNAME, DEFAULT_TABLESPACE FROM dba_users;

--�������� �ӽ��������̺����̽� Ȯ��
SELECT username, temporary_tablespace
FROM dba_users;



alter session set "_ORACLE_SCRIPT"=true;

create user c##snake identified by 123456
default tablespace example temporary tablespace temp ;

grant connect, resource, dba to c##snake;

--��������
DROP USER c##snake CASCADE;


SELECT USERNAME, DEFAULT_TABLESPACE FROM USER_USERS WHERE USERNAME = 'SCOTT';

ALTER USER c##snake DEFAULT TABLESPACE example;

--���̺����̽� ����
DROP TABLESPACE example INCLUDING CONTENTS;

--���̺����̽� �����
create tablespace example
datafile 'C:\app\B\product\21c\oradata\XE\example01.dbf'
size 100m
autoextend on;
