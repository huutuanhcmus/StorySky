use StorySky;

INSERT INTO `storysky`.`category` (`namecategory`, `codecategory`) VALUES ('Ngôn tình', 'ngon-tinh');
INSERT INTO `storysky`.`category` (`namecategory`, `codecategory`) VALUES ('Trinh thám', 'trinh-tham');

INSERT INTO `storysky`.`story` (`idcategory`, `namestory`, `introducestory`, `imagestory`, `createdby`) VALUES ('7', 'CÔ DÂU TRĂM TỶ, TỔNG TÀI ĐẠI NHÂN XIN DỊU DÀNG', 'CÔ DÂU TRĂM TỶ, TỔNG TÀI ĐẠI NHÂN XIN DỊU DÀNG', 'https://goctruyen.com/public/frontend/images/codautramtytongtaidainhanxindiudangxjfS1tJYk7.jpg', 'user1');
INSERT INTO `storysky`.`story` (`idcategory`, `namestory`, `introducestory`, `imagestory`, `createdby`) VALUES ('7', 'TỔNG GIÁM ĐỐC TÀ ÁC YÊU THƯƠNG VỢ', 'TỔNG GIÁM ĐỐC TÀ ÁC YÊU THƯƠNG VỢ', 'https://goctruyen.com/public/frontend/images/tonggiamdoctaacyeuthuongvo1v9nGHzbEh.jpg', 'user1');
INSERT INTO `storysky`.`story` (`idcategory`, `namestory`, `introducestory`, `imagestory`, `createdby`) VALUES ('8', 'ĐÔNG PHƯƠNG THẦN THÁM', 'ĐÔNG PHƯƠNG THẦN THÁM', 'https://static.8cache.com/cover/o/eJzLyTDV13X39Eyv8LZ0LDOL1A8LDvAOMg0xMizz1HeEgtwwE_1ECyOjFD_d0vxCR_1yI0NT3QxjIyMANz4RkQ==/dong-phuong-than-tham-180620.jpg', 'user2');

INSERT INTO `storysky`.`collectionstory` (`idstory`, `namecollectionstory`, `contentcollectionstory`, `createdby`) VALUES ('13', 'Tập 1', 'Nội dung 1', 'user1');
INSERT INTO `storysky`.`collectionstory` (`idstory`, `namecollectionstory`, `contentcollectionstory`, `createdby`) VALUES ('13', 'Tập 2', 'Nội dung 2', 'user1');
INSERT INTO `storysky`.`collectionstory` (`idstory`, `namecollectionstory`, `contentcollectionstory`, `createdby`) VALUES ('14', 'Tập 1', 'Nội dung 1', 'user1');
INSERT INTO `storysky`.`collectionstory` (`idstory`, `namecollectionstory`, `contentcollectionstory`, `createdby`) VALUES ('14', 'Tập 2', 'Nội dung 2', 'user1');
INSERT INTO `storysky`.`collectionstory` (`idstory`, `namecollectionstory`, `contentcollectionstory`, `createdby`) VALUES ('15', 'Tập 1', 'Nội dung 1', 'user2');
INSERT INTO `storysky`.`collectionstory` (`idstory`, `namecollectionstory`, `contentcollectionstory`, `createdby`) VALUES ('15', 'Tập 2', 'Nội dung 2', 'user2');

INSERT INTO `storysky`.`role` (`name`, `code`) VALUES ('Khách hàng', 'user');
INSERT INTO `storysky`.`role` (`name`, `code`) VALUES ('Quản lý', 'admin');

INSERT INTO `storysky`.`user` (`username`, `password`, `fullname`, `status`, `roleid`) VALUES ('user1', '123456', 'Người dùng 1', '1', '5');
INSERT INTO `storysky`.`user` (`username`, `password`, `fullname`, `status`, `roleid`) VALUES ('user2', '123456', 'Người dùng 2', '1', '5');