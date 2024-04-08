

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
