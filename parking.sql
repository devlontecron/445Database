CREATE TABLE Lot (
    LotName VARCHAR(30) PRIMARY KEY,
    Location VARCHAR(30),
    Capacity INTEGER,
    Floors INTEGER
);

CREATE TABLE `Space` (
    SpaceNo INTEGER PRIMARY KEY,
    SpaceType VARCHAR(30)
);


CREATE TABLE StaffSpace (
    StaffNo INTEGER,
    SpaceNo INTEGER,
    PRIMARY KEY (StaffNo, SpaceNo),
    FOREIGN KEY (StaffNo)REFERENCES Staff(StaffNo),
    FOREIGN KEY (SpaceNo)REFERENCES Covered(SpaceNo)
);

CREATE TABLE Staff (
    StaffNo INTEGER PRIMARY KEY,
    PhoneExt INTEGER,
    LicPlateNo VARCHAR(30)
);


CREATE TABLE Covered (
    SpaceNo INTEGER PRIMARY KEY,
    MonthlyRate DOUBLE,
    FOREIGN KEY (SpaceNo) REFERENCES `Space`(SpaceNo)
);

CREATE TABLE Uncovered (
    SpaceNo INTEGER PRIMARY KEY,
    FOREIGN KEY (SpaceNo) REFERENCES `Space`(SpaceNo)
);

CREATE TABLE SpaceBooking (
    BookingId INTEGER PRIMARY KEY,
    SpaceNo INTEGER,
    StaffNo INTEGER,
    VisitorLic VARCHAR(30),
    DateOfVisit DATE,
    FOREIGN KEY (SpaceNo)REFERENCES Covered(SpaceNo),
    FOREIGN KEY (StaffNo)REFERENCES Staff(StaffNo)
);



INSERT INTO Lot VALUES ("LotA", "NE A St", 50, 5),("LotB", "NE B St", 100, 3);

INSERT INTO `Space` VALUES (1, "Covered"),(3, "Covered"),(4, "Covered"),(5, "Uncovered");

INSERT INTO Covered VALUES (1, 55.00),(3, 25.00),(4, 25.00);

INSERT INTO Uncovered VALUES (5);

INSERT INTO StaffSpace VALUES (9001, 1),(9003, 3),(9004, 4);

INSERT INTO Staff VALUES (9001, 901, "ABC123"), (9003, 903, "DEF456"), (9004, 904, "GHI789");

INSERT INTO SpaceBooking VALUES (98765, 4, 9001, "GST123", '2017-03-13'); 
