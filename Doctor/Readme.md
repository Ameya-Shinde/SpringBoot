# FrameWorks and Language Used
* SpringBoot
* Java

# Data Flow
* Controller - Rest Controller

Used with @GetMapping, @RequestMapping, @PutMapping, @RequestBody, @RequestParam, @Nullable, @DeleteMapping and @AutoWired and linked with the business logic in the Service Class

* Services

1. add doctor
2. add patient with doctorId
3. get list of doctors
4. get list of patients

* Repository

  Jpa Repository is used which extends CRUD Respository
  
* DataBase Design

![Doctor](https://user-images.githubusercontent.com/93002372/223197414-677b1b1e-abe5-4d2c-8799-19b0ec4a9526.png)
 
 

# Data Structure Used

H2 Database

# Project Summary 
* This a simple API to Book a Doctor
* You can save both doctor and patient details
* You can assign a doctor to a patient
* You get list of all doctors and patients
* You can see complete doctor details in patient details

