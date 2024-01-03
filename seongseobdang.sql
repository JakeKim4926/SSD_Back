-- create database db_seongseob;

-- use db_seongseob;

CREATE TABLE IF NOT EXISTS `location` (
   `location_id` INT AUTO_INCREMENT,
   `city` varchar(1000) not null,
    `area` varchar(1000) not null,
  PRIMARY KEY (`location_id`)
) ENGINE = InnoDB;

#첫번째 1~5 대덕구, 동구, 중구, 서구, 유성구
INSERT INTO `location` VALUES(0, "대전", "대덕구" );
INSERT INTO `location` VALUES(0, "대전", "동구" );
INSERT INTO `location` VALUES(0, "대전", "중구" );
INSERT INTO `location` VALUES(0, "대전", "서구" );
INSERT INTO `location` VALUES(0, "대전", "유성구" );

CREATE TABLE IF NOT EXISTS `mountain` (
   `location_id` INT not null,
   `mountain_id` INT AUTO_INCREMENT,
   `latitude` DOUBLE not null,
   `longtitude` DOUBLE not null,
   `time` INT not null,
   `mountain` varchar(1000) not null,
  PRIMARY KEY(mountain_id),
    CONSTRAINT `fk_mountain_location`
        FOREIGN KEY (`location_id`)
        REFERENCES `location` (`location_id`)
        on delete cascade
        on update cascade
) ENGINE = InnoDB;

#첫번째 1~5 대덕구, 동구, 중구, 서구, 유성구
INSERT INTO `mountain` 
VALUES(4, 0, 36.319828, 127.3583026, 60, "도솔산");
INSERT INTO `mountain` 
VALUES(5, 0, 36.33270928567692,  127.29071024612026 , 60, "빈계산");
INSERT INTO `mountain` 
VALUES(1, 0, 35.99282419990582,  127.44739982191348, 60, "성치산");
INSERT INTO `mountain` 
VALUES(1, 0, 36.38476631809787,  127.43942566978934 , 60, "계족산");
INSERT INTO `mountain` 
VALUES(2, 0, 36.21187287891453,  127.59609181509127 , 60, "대성산");
INSERT INTO `mountain` 
VALUES(2, 0, 36.21187287891453,  127.59609181509127 , 60, "동광산");
INSERT INTO `mountain` 
VALUES(2, 0, 36.32484203531958,  127.45292632587824  , 60, "황태봉");
INSERT INTO `mountain` 
VALUES(2, 0, 36.36059248207928,  127.46558989921093  , 60, "고봉산");
INSERT INTO `mountain`
VALUES(2, 0,  36.3018956763546,  127.48009275095554  , 60, "식장산");
INSERT INTO `mountain` 
VALUES(2, 0,  36.395532526299164,  127.4765659662425 , 60, "함각산");
INSERT INTO mountain VALUES(4, 0, 36.30814773870371,  127.3791149357141 , 60, "오량산");
INSERT INTO mountain VALUES(4, 0, 36.28500396023034,  127.33345743486882, 60, "구봉산");

INSERT INTO mountain VALUES(5, 0, 36.295040285465014,  127.310255479919, 60, "산장산");
INSERT INTO mountain VALUES(5, 0, 36.37945764484719,  127.30960972629141, 60, "지족산");
INSERT INTO mountain VALUES(5, 0, 36.41548223358525,  127.36823539468412, 60, "적오산");
INSERT INTO mountain VALUES(5, 0, 36.3627175953284,  127.30989716420943, 60, "왕가산");

INSERT INTO mountain VALUES(3, 0, 36.23452392600122,  127.38796976485513, 60, "천비산");
INSERT INTO mountain VALUES(3, 0, 36.29614038536266,  127.42189239783883, 60, "보문산");

CREATE TABLE IF NOT EXISTS `user` (
  `id` VARCHAR(100) NOT NULL PRIMARY KEY,
  `pw` VARCHAR(100) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `age` VARCHAR(100) NOT NULL,
  `nickname` VARCHAR(100) NOT NULL,
  `gender` VARCHAR(100) NOT NULL
) ENGINE = InnoDB;

insert into user values('ssafy', '1234','김싸피', '26', 'jjafy', '남자');

create table IF NOT EXISTS `board`(
#기본 키 는 id
    `location_id` INT not null, 
    `mountain_id` INT not null,
    `id` VARCHAR(100) NOT NULL,
    `board_id` INT AUTO_INCREMENT,
    `title` varchar(1000) not null,
    `writer` varchar(1000) not null,
    `content` varchar(1000) not null,
    `reg_date` DATETIME not null,
    `view_cnt` INT not null default 0,
     PRIMARY KEY(board_id),
    CONSTRAINT `fk_board_location`
        FOREIGN KEY (`location_id`)
        REFERENCES `location` (`location_id`)
        on delete cascade
        on update cascade,
	CONSTRAINT `fk_board_mountain`
        FOREIGN KEY (`mountain_id`)
        REFERENCES `mountain` (`mountain_id`)
        on delete cascade
        on update cascade,
	CONSTRAINT `fk_board_user`
        FOREIGN KEY (`id`)
        REFERENCES `user` (`id`)
        on delete cascade
        on update cascade
    
)engine = InnoDB;

INSERT INTO `board` 
VALUES(5, 1, "ssafy", 0, "빈계산?? empty calculation??", "이수민", "라임 칭찬 스티커", now(), 0);

