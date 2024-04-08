

CREATE TABLE Dentist (
    DentistID INT PRIMARY KEY,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    ContactPhoneNumber VARCHAR(20),
    Email VARCHAR(255),
    Specialization VARCHAR(255)
);

CREATE TABLE Patient (
    PatientID INT PRIMARY KEY,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    ContactPhoneNumber VARCHAR(20),
    Email VARCHAR(255),
    MailingAddress VARCHAR(255),
    DateOfBirth DATE
);

CREATE TABLE Surgery (
    SurgeryID INT PRIMARY KEY,
    SurgeryName VARCHAR(255),
    LocationAddress VARCHAR(255),
    TelephoneNumber VARCHAR(20)
);

CREATE TABLE Appointment (
    AppointmentID INT PRIMARY KEY,
    AppointmentDate DATE,
    AppointmentTime TIME,
    DentistID INT,
    PatientID INT,
    SurgeryID INT,
    Status VARCHAR(20),
    FOREIGN KEY (DentistID) REFERENCES Dentist(DentistID),
    FOREIGN KEY (PatientID) REFERENCES Patient(PatientID),
    FOREIGN KEY (SurgeryID) REFERENCES Surgery(SurgeryID)
);
CREATE TABLE Bill (
    BillID INT PRIMARY KEY,
    AppointmentID INT,
    TotalAmount DECIMAL(10, 2),
    PaymentStatus VARCHAR(20),
    FOREIGN KEY (AppointmentID) REFERENCES Appointment(AppointmentID)
);

-- Dummy Dentist data
INSERT INTO Dentist (DentistID, FirstName, LastName, ContactPhoneNumber, Email, Specialization)
VALUES 
(1, 'John', 'Smith', '123-456-7890', 'john.smith@example.com', 'General Dentistry'),
(2, 'Emily', 'Jones', '234-567-8901', 'emily.jones@example.com', 'Orthodontics');

-- Dummy Patient data
INSERT INTO Patient (PatientID, FirstName, LastName, ContactPhoneNumber, Email, MailingAddress, DateOfBirth)
VALUES 
(1, 'Alice', 'Johnson', '345-678-9012', 'alice.johnson@example.com', '123 Main St, Anytown, USA', '1990-05-15'),
(2, 'Bob', 'Williams', '456-789-0123', 'bob.williams@example.com', '456 Oak St, Anytown, USA', '1985-09-20');

-- Dummy Surgery data
INSERT INTO Surgery (SurgeryID, SurgeryName, LocationAddress, TelephoneNumber)
VALUES 
(1, 'Advantis Dental Anytown', '789 Elm St, Anytown, USA', '567-890-1234'),
(2, 'Advantis Dental Downtown', '321 Oak St, Downtown, USA', '678-901-2345');

-- Dummy Appointment data
INSERT INTO Appointment (AppointmentID, AppointmentDate, AppointmentTime, DentistID, PatientID, SurgeryID, Status)
VALUES 
(1, '2024-04-08', '10:00:00', 1, 1, 1, 'Scheduled'),
(2, '2024-04-08', '11:00:00', 2, 2, 2, 'Scheduled');

-- Dummy Bill data
INSERT INTO Bill (BillID, AppointmentID, TotalAmount, PaymentStatus)
VALUES 
(1, 1, 100.00, 'Paid'),
(2, 2, 150.00, 'Pending');

SELECT * FROM Dentist ORDER BY LastName ASC;

SELECT A.*, P.FirstName AS PatientFirstName, P.LastName AS PatientLastName, P.ContactPhoneNumber AS PatientContactPhoneNumber
FROM Appointment A
JOIN Patient P ON A.PatientID = P.PatientID
WHERE A.DentistID = 1;

SELECT A.*, S.SurgeryName, S.LocationAddress, S.TelephoneNumber
FROM Appointment A
JOIN Surgery S ON A.SurgeryID = S.SurgeryID;

SELECT * FROM Appointment WHERE PatientID = 1 AND AppointmentDate = '2024-04-08';


