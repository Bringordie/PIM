DROP TABLE if exists products;
DROP TABLE if exists minorCategories;
DROP TABLE if exists mainCategories;


CREATE TABLE mainCategories (
	categoryid INTEGER not null AUTO_INCREMENT unique,
    mainCategoryName VARCHAR(45),
    primary key (categoryid)
);

insert into mainCategories (mainCategoryName) values ("Frugt og grønt");
insert into mainCategories (mainCategoryName) values ("Kød");
insert into mainCategories (mainCategoryName) values ("Frost");
insert into mainCategories (mainCategoryName) values ("Drikkevarer");

CREATE TABLE minorCategories (
	categoryid INTEGER not null AUTO_INCREMENT unique,
    minorCategoryName VARCHAR(45),
    primary key (categoryid)
);

insert into minorCategories (minorCategoryName) values ("Salat");
insert into minorCategories (minorCategoryName) values ("Frugt");
insert into minorCategories (minorCategoryName) values ("Oksekød");
insert into minorCategories (minorCategoryName) values ("Svinekød");
insert into minorCategories (minorCategoryName) values ("Grøntsager på frost");
insert into minorCategories (minorCategoryName) values ("Is");
insert into minorCategories (minorCategoryName) values ("Øl");
insert into minorCategories (minorCategoryName) values ("Sodavand");

CREATE TABLE products (
    producid INTEGER not null unique,
    name VARCHAR(45) not null,
    nameDescription VARCHAR(45),
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

