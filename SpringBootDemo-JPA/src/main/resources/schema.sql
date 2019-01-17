CREATE TABLE `USER_DEMO`(
  `id` varchar(255) not null primary key ,
  `user_name` varchar(255),
  `pass_word` varchar(255),
  `email` text,
  `nick_name` varchar(255),
  `create_time` datetime DEFAULT NULL,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);