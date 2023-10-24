USE `library_schema`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

-- Table structure for table `members`

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Inserting data for table `members`
INSERT INTO `users`
VALUES
('librarian','{bcrypt}$2a$10$qmTruQpGuPWp/Xr9scA/zu692UcdsI4WSdpqUmGsA3xWlPl9VEvaS',1),
('admin','{bcrypt}$2a$10$qmTruQpGuPWp/Xr9scA/zu692UcdsI4WSdpqUmGsA3xWlPl9VEvaS',1);

-- Table structure for table `authorities`

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Inserting data for table `roles`

INSERT INTO `authorities`
VALUES
('librarian','ROLE_LIBRARIAN'),
('admin','ROLE_LIBRARIAN'),
('admin','ROLE_ADMIN');

