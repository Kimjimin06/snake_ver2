CREATE TABLE TBL_MEMBER (
	MIdx	int		NOT NULL,
	MemberId	varchar(255)		NULL,
	MemberPw	varchar(255)		NULL,
	MemberName	varchar(255)		NULL,
	MemberSex	int		NULL,
   	MemberPhone	varchar(255)		NULL,
	MRegDate	date		NULL
);
--alter table TBL_MEMBER modify MemberSex int;
--desc TBL_MEMBER;

CREATE TABLE TBL_COMMUNITY_CATEGORY (
	ComCateIdx	int		NOT NULL,
	ComCateName	varchar(255)		NULL,
	ComCateUseState	varchar(255)		NULL
);

CREATE TABLE Tbl_Community (
	ComIdx	int		NOT NULL,
	ComCateIdx	int		NOT NULL,
	MIdx	int		NOT NULL,
	ComTitle	varchar(255)		NULL,
	ComContent	varchar(255)		NULL,
	ComRegDate	date		NULL,
	ComDelDate	date		NULL,
	ComUpDate	date		NULL,
	ComintoDate	varchar(255)		NULL,
	ComToCount	int		NULL,
	ComStartDate	date		NULL,
	ComEndDate	date		NULL
);
--alter table Tbl_Community modify ComintoDate int;
--desc Tbl_Community;

CREATE TABLE Tbl_Community_Comment (
	CCIdx	int		NOT NULL,
	MIdx	int		NOT NULL,
	ComIdx	int		NOT NULL,
	CCRefNum	int		NULL,
	CCNum	int		NULL,
	CCGroupNum	int		NULL,
	CCContent	varchar(255)		NULL,
	CCRegDate	date		NULL,
	CCUpDate	date		NULL,
	CCDelDate	date		NULL
);

CREATE TABLE Tbl_StudyCafe (
	SCIdx	int		NOT NULL,
	SCName	varchar(255)		NULL,
	SCPhone	varchar(255)		NULL,
	SCEmail	varchar(255)		NULL,
	SCManageTime	Date		NULL,
	SCLastTime	Date		NULL
);

CREATE TABLE Tbl_StudyCafeImg (
	SCImgIdx	int		NOT NULL,
	SCIdx	int		NOT NULL,
	SCImg	varchar(255)		NULL
);

CREATE TABLE Tbl_StudyInInfo (
	SeatNum	int		NOT NULL,
	SCIdx	int		NOT NULL,
	SIINum	int		NULL,
	SeatUseState	varchar(255)		NULL
);

CREATE TABLE Tbl_StudyInPare (
	SIPIdx	int		NOT NULL,
	SCIdx	int		NOT NULL,
	SIPName	varchar(255)		NULL,
	SIPPrice	int		NULL
);

CREATE TABLE Tbl_StudyGInfo (
	SGIIdx	int		NOT NULL,
	SCIdx	int		NOT NULL,
	SGINum	int		NULL,
	SGIUseState	varchar(255)		NULL,
	SGIContent1	varchar(255)		NULL,
	SGIContent2	varchar(255)		NULL,
	SGIContent3	varchar(255)		NULL,
	SGIContent4	varchar(255)		NULL
);

CREATE TABLE Tbl_StudyReview (
	SRIdx	int		NOT NULL,
	SGIIdx	int		NOT NULL,
	MIdx	int		NOT NULL,
	SRcontent	varchar(255)		NULL,
	SRRegDate	date		NULL,
	SRDelDate	date		NULL,
	SRUpDate	date		NULL,
	SRStar	int		NULL
);

CREATE TABLE Tbl_StudyGImg (
	SGImgIdx	int		NOT NULL,
	SGIIdx	int		NOT NULL,
	SGImg	varchar(255)		NULL
);

CREATE TABLE Tbl_StudyGPare (
	SGPIdx  int		NOT NULL,
	SGIIdx	int		NOT NULL,
	SGPName	varchar(255)		NULL,
	SGPPrice	varchar(255)		NULL
);

CREATE TABLE Tbl_MemberInInfo (
	MIdx	int		NOT NULL,
	SeatNum	int		NOT NULL,
	MUseTime	int		NULL,
	MStateinDate	date		NULL,
	MEndinDate	date		NULL
);

CREATE TABLE Tbl_TogetherStudy (
	MIdx	int		NOT NULL,
	ComIdx	int		NOT NULL
);

CREATE TABLE Tbl_StudyGOrder (
	SGOIdx	int		NOT NULL,
	SGIdx	int		NOT NULL,
	MIdx	int		NOT NULL,
	SGONum	int		NULL,
	SGORegDate	date		NULL,
	SGOStartDate	date		NULL,
	SGOEndDate	date		NULL
);

ALTER TABLE Tbl_Member ADD CONSTRAINT PK_TBL_MEMBER PRIMARY KEY (
	MIdx
);

ALTER TABLE Tbl_Community_Category ADD CONSTRAINT PK_TBL_COMMUNITY_CATEGORY PRIMARY KEY (
	ComCateIdx
);

ALTER TABLE Tbl_Community ADD CONSTRAINT PK_TBL_COMMUNITY PRIMARY KEY (
	ComIdx
);

ALTER TABLE Tbl_Community_Comment ADD CONSTRAINT PK_TBL_COMMUNITY_COMMENT PRIMARY KEY (
	CCIdx
);

ALTER TABLE Tbl_StudyCafe ADD CONSTRAINT PK_TBL_STUDYCAFE PRIMARY KEY (
	SCIdx
);

ALTER TABLE Tbl_StudyCafeImg ADD CONSTRAINT PK_TBL_STUDYCAFEIMG PRIMARY KEY (
	SCImgIdx
);

ALTER TABLE Tbl_StudyInInfo ADD CONSTRAINT PK_TBL_STUDYININFO PRIMARY KEY (
	SeatNum
);

ALTER TABLE Tbl_StudyInPare ADD CONSTRAINT PK_TBL_STUDYINPARE PRIMARY KEY (
	SIPIdx
);

ALTER TABLE Tbl_StudyGInfo ADD CONSTRAINT PK_TBL_STUDYGINFO PRIMARY KEY (
	SGIIdx
);

ALTER TABLE Tbl_StudyReview ADD CONSTRAINT PK_TBL_STUDYREVIEW PRIMARY KEY (
	SRIdx
);

ALTER TABLE Tbl_StudyGImg ADD CONSTRAINT PK_TBL_STUDYGIMG PRIMARY KEY (
	SGImgIdx
);

ALTER TABLE Tbl_StudyGPare ADD CONSTRAINT PK_TBL_STUDYGPARE PRIMARY KEY (
	SGPIdx
);

ALTER TABLE Tbl_MemberInInfo ADD CONSTRAINT PK_TBL_MEMBERININFO PRIMARY KEY (
	MIdx
);

ALTER TABLE Tbl_TogetherStudy ADD CONSTRAINT PK_TBL_TOGETHERSTUDY PRIMARY KEY (
	MIdx,
	ComIdx
);

ALTER TABLE Tbl_StudyGOrder ADD CONSTRAINT PK_TBL_STUDYGORDER PRIMARY KEY (
	SGOIdx
);

ALTER TABLE Tbl_Community ADD CONSTRAINT FK_Tbl_Community_Category_TO_Tbl_Community_1 FOREIGN KEY (
	ComCateIdx
)
REFERENCES Tbl_Community_Category (
	ComCateIdx
);

ALTER TABLE Tbl_Community ADD CONSTRAINT FK_Tbl_Member_TO_Tbl_Community_1 FOREIGN KEY (
	MIdx
)
REFERENCES Tbl_Member (
	MIdx
);

ALTER TABLE Tbl_Community_Comment ADD CONSTRAINT FK_Tbl_Member_TO_Tbl_Community_Comment_1 FOREIGN KEY (
	MIdx
)
REFERENCES Tbl_Member (
	MIdx
);

ALTER TABLE Tbl_Community_Comment ADD CONSTRAINT FK_Tbl_Community_TO_Tbl_Community_Comment_1 FOREIGN KEY (
	ComIdx
)
REFERENCES Tbl_Community (
	ComIdx
);

ALTER TABLE Tbl_StudyCafeImg ADD CONSTRAINT FK_Tbl_StudyCafe_TO_Tbl_StudyCafeImg_1 FOREIGN KEY (
	SCIdx
)
REFERENCES Tbl_StudyCafe (
	SCIdx
);

ALTER TABLE Tbl_StudyInInfo ADD CONSTRAINT FK_Tbl_StudyCafe_TO_Tbl_StudyInInfo_1 FOREIGN KEY (
	SCIdx
)
REFERENCES Tbl_StudyCafe (
	SCIdx
);

ALTER TABLE Tbl_StudyInPare ADD CONSTRAINT FK_Tbl_StudyCafe_TO_Tbl_StudyInPare_1 FOREIGN KEY (
	SCIdx
)
REFERENCES Tbl_StudyCafe (
	SCIdx
);

ALTER TABLE Tbl_StudyGInfo ADD CONSTRAINT FK_Tbl_StudyCafe_TO_Tbl_StudyGInfo_1 FOREIGN KEY (
	SCIdx
)
REFERENCES Tbl_StudyCafe (
	SCIdx
);

ALTER TABLE Tbl_StudyReview ADD CONSTRAINT FK_Tbl_StudyGInfo_TO_Tbl_StudyReview_1 FOREIGN KEY (
	SGIIdx
)
REFERENCES Tbl_StudyGInfo (
	SGIIdx
);

ALTER TABLE Tbl_StudyReview ADD CONSTRAINT FK_Tbl_Member_TO_Tbl_StudyReview_1 FOREIGN KEY (
	MIdx
)
REFERENCES Tbl_Member (
	MIdx
);

ALTER TABLE Tbl_StudyGImg ADD CONSTRAINT FK_Tbl_StudyGInfo_TO_Tbl_StudyGImg_1 FOREIGN KEY (
	SGIIdx
)
REFERENCES Tbl_StudyGInfo (
	SGIIdx
);

ALTER TABLE Tbl_StudyGPare ADD CONSTRAINT FK_Tbl_StudyGInfo_TO_Tbl_StudyGPare_1 FOREIGN KEY (
	SGIIdx
)
REFERENCES Tbl_StudyGInfo (
	SGIIdx
);

ALTER TABLE Tbl_MemberInInfo ADD CONSTRAINT FK_Tbl_Member_TO_Tbl_MemberInInfo_1 FOREIGN KEY (
	MIdx
)
REFERENCES Tbl_Member (
	MIdx
);

ALTER TABLE Tbl_MemberInInfo ADD CONSTRAINT FK_Tbl_StudyInInfo_TO_Tbl_MemberInInfo_1 FOREIGN KEY (
	SeatNum
)
REFERENCES Tbl_StudyInInfo (
	SeatNum
);

ALTER TABLE Tbl_TogetherStudy ADD CONSTRAINT FK_Tbl_Member_TO_Tbl_TogetherStudy_1 FOREIGN KEY (
	MIdx
)
REFERENCES Tbl_Member (
	MIdx
);

ALTER TABLE Tbl_TogetherStudy ADD CONSTRAINT FK_Tbl_Community_TO_Tbl_TogetherStudy_1 FOREIGN KEY (
	ComIdx
)
REFERENCES Tbl_Community (
	ComIdx
);

ALTER TABLE Tbl_StudyGOrder ADD CONSTRAINT FK_Tbl_StudyGInfo_TO_Tbl_StudyGOrder_1 FOREIGN KEY (
	SGIdx
)
REFERENCES Tbl_StudyGInfo (
	SGIIdx
);

ALTER TABLE Tbl_StudyGOrder ADD CONSTRAINT FK_Tbl_Member_TO_Tbl_StudyGOrder_1 FOREIGN KEY (
	MIdx
)
REFERENCES Tbl_Member (
	MIdx
);

-- ?‚ ì§? ê¸°ë³¸ê°’ìœ¼ë¡? ?ˆ˜? •
alter table tbl_member modify mregdate date default sysdate;
alter table tbl_studygorder modify sgoregdate date default sysdate;
alter table tbl_community modify comregdate date default sysdate;
alter table tbl_community_comment modify ccregdate date default sysdate;
alter table tbl_studyreview modify srregdate date default sysdate;





-- ½ÃÄö½º 
-- Tbl_Member MIdx
CREATE SEQUENCE c##snake.Mem_seq
   INCREMENT BY 1
   START WITH 1
   MINVALUE 1
   MAXVALUE 9999
   NOCYCLE
   NOCACHE
   NOORDER;
    
-- Tbl_StudyInPare SIPIdx
CREATE SEQUENCE c##snake.SIPare_seq
   INCREMENT BY 1
   START WITH 1
   MINVALUE 1
   MAXVALUE 9999
   NOCYCLE
   NOCACHE
   NOORDER;

-- Tbl_StudyCafeImg SCImgIdx
CREATE SEQUENCE c##snake.SCImg_seq
   INCREMENT BY 1
   START WITH 1
   MINVALUE 1
   MAXVALUE 9999
   NOCYCLE
   NOCACHE
   NOORDER;

-- Tbl_StudyInInfo SeatNum
CREATE SEQUENCE c##snake.SIInfo_seq
   INCREMENT BY 1
   START WITH 1
   MINVALUE 1
   MAXVALUE 9999
   NOCYCLE
   NOCACHE
   NOORDER;

-- Tbl_StudyGInfo SGIIdx
CREATE SEQUENCE c##snake.SGInfo_seq
   INCREMENT BY 1
   START WITH 1
   MINVALUE 1
   MAXVALUE 9999
   NOCYCLE
   NOCACHE
   NOORDER;

-- Tbl_StudyGOrder SGOIdx
CREATE SEQUENCE c##snake.SGOrder_seq
   INCREMENT BY 1
   START WITH 1
   MINVALUE 1
   MAXVALUE 9999
   NOCYCLE
   NOCACHE
   NOORDER;

-- Tbl_StudyGPare SGPIdx
CREATE SEQUENCE c##snake.SGPare_seq
   INCREMENT BY 1
   START WITH 1
   MINVALUE 1
   MAXVALUE 9999
   NOCYCLE
   NOCACHE
   NOORDER;

-- Tbl_StudyGImg SGImgIdx
CREATE SEQUENCE c##snake.SGImg_seq
   INCREMENT BY 1
   START WITH 1
   MINVALUE 1
   MAXVALUE 9999
   NOCYCLE
   NOCACHE
   NOORDER;

-- Tbl_StudyReview SRIdx
CREATE SEQUENCE c##snake.SReview_seq
   INCREMENT BY 1
   START WITH 1
   MINVALUE 1
   MAXVALUE 9999
   NOCYCLE
   NOCACHE
   NOORDER;

-- Tbl_Community ComIdx
CREATE SEQUENCE c##snake.Com_seq
   INCREMENT BY 1
   START WITH 1
   MINVALUE 1
   MAXVALUE 9999
   NOCYCLE
   NOCACHE
   NOORDER;

-- Tbl_Community_Category ComCateIdx
CREATE SEQUENCE c##snake.ComCate_seq
   INCREMENT BY 1
   START WITH 1
   MINVALUE 1
   MAXVALUE 9999
   NOCYCLE
   NOCACHE
   NOORDER;

-- Tbl_Community_Comment CCIdx
CREATE SEQUENCE c##snake.ComCom_seq
   INCREMENT BY 1
   START WITH 1
   MINVALUE 1
   MAXVALUE 9999
   NOCYCLE
   NOCACHE
   NOORDER;
   
--ALTER session set NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI';   

commit;
   