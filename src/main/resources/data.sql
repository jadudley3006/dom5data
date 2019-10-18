drop table IF EXISTS ITEM;
drop table IF EXISTS ITEM_ATTRIBUTE;
drop table IF EXISTS WEAPON;

--create TABLE ITEM (
--  id INT AUTO_INCREMENT PRIMARY KEY,
--  name VARCHAR(150) NOT NULL,
--  type VARCHAR(50) NOT NULL,
--  weapon INT DEFAULT NULL,
--  armor INT DEFAULT NULL,
--  constlevel INT NOT NULL,
--  mainpath VARCHAR(5) NOT NULL,
--  mainlevel VARCHAR(5) NOT NULL,
--  secondarypath VARCHAR(5) DEFAULT NULL,
--  secondarylevel VARCHAR(5) DEFAULT NULL
--);
--
--create TABLE ITEM_ATTRIBUTE (
--  id INT AUTO_INCREMENT PRIMARY KEY,
--  item_id INT NOT NULL,
--  key VARCHAR(250) DEFAULT NULL,
--  value VARCHAR(250) DEFAULT NULL,
--  FOREIGN KEY (item_id) REFERENCES ITEM(id)
--);

--create TABLE WEAPON (
--    id INT NOT NULL,
--    name VARCHAR(150) NOT NULL,
--    effect_record_id INT NOT NULL,
--    att INT NOT NULL,
--    def INT NOT NULL,
--    len INT NOT NULL,
--    nratt INT NOT NULL,
--    ammo INT NOT NULL,
--    secondaryeffect INT NOT NULL,
--    secondaryeffectalways INT NOT NULL,
--    rcost INT NOT NULL
--);