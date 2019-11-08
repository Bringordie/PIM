DROP TABLE if exists mainCategories;
DROP TABLE if exists minorCategories;
DROP TABLE if exists products;


CREATE TABLE mainCategories (
	categoryid INTEGER not null AUTO_INCREMENT unique,
    mainCategoryName VARCHAR(45),
    primary key (categoryid)
);

CREATE TABLE minorCategories (
	categoryid INTEGER not null AUTO_INCREMENT unique,
    minorCategoryName VARCHAR(45),
    primary key (categoryid)
);

CREATE TABLE products (
    producid INTEGER not null unique,
    name VARCHAR(45) not null,
    description VARCHAR(200),
    companyName VARCHAR(45),
    price DOUBLE,
    quantity INTEGER,
    pictureName VARCHAR(45),
    publishedStatus tinyint,
    minorCategory INTEGER,
    mainCategory INTEGER,
    FOREIGN KEY (mainCategory) REFERENCES mainCategories(categoryid),
    FOREIGN KEY (minorCategory) REFERENCES minorCategories(categoryid)
);