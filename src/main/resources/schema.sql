DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
    `id` INT AUTO_INCREMENT NOT NULL,
    `title` VARCHAR(255) NOT NULL,
    `author` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);
