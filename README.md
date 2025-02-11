# FullStack CRUD ContactList

## Overview
A CRUD-based contact management system with profile image upload capabilities. Organizes contact details (name, email, phone, address) in a centralized, paginated interface.

---

## Features
- **CRUD Operations**: Full Create, Read, Update, Delete functionality.
- **Profile Image Upload**: Supports image uploads for contacts.
- **Pagination**: User-friendly interface with multi-page navigation.
- **Detailed Contact Storage**: Stores name, email, phone, address, job title, and status.

---

## Tech Stack
| Category       | Technologies/Tools                                  |  
|----------------|----------------------------------------------------|  
| **Backend**    | Spring Boot 3.3.5, JPA, Lombok                     |  
| **Frontend**   | React                                              |  
| **Database**   | PostgreSQL                                         |  
| **Testing**    | Selenium 4.20.0, JUnit 5, WebDriverManager 5.7.0   |  
| **Infra**      | AWS (Hosting), GitHub (Version Control)            |  

---

## Installation
### Prerequisites
- JDK 17+, Maven, PostgreSQL, Node.js/npm.
- Frontend Repo: [React-CRUDContactList](https://github.com/Nofate4you/React-CRUDContactList).

### Steps
1. **Clone & Configure Backend**:
   ```bash  
   git clone https://github.com/KevinLlano/Java_CRUDContactList.git  
   cd contactlistapi  
   ```  
   Update `application.properties`:
   ```properties  
   spring.datasource.url=jdbc:postgresql://localhost:5432/contactlistdb  
   spring.datasource.username=postgres  
   spring.datasource.password=yourpassword  
   ```  
   Run:
   ```bash  
   mvn spring-boot:run  # Starts backend at http://localhost:8080  
   ```  

2. **Set Up Frontend**:
   ```bash  
   cd contactlistweb  
   npm install && npm start  # Starts frontend at http://localhost:3000  
   ```  

3. **Database Setup**:
   ```sql  
   CREATE DATABASE contactlistdb;  # Run in PostgreSQL  
   ```  

---

## Testing Documentation
### Test Setup
- **Framework**: JUnit 5 + Selenium WebDriver.
- **Browser Automation**:
   - `WebDriverManager` auto-configures ChromeDriver.
   - Explicit waits (20-second timeout) for dynamic elements.
- **Test Flow**:
   1. Navigate to `http://localhost:3000/contacts`.
   2. Add a contact via form submission.
   3. Validate contact appears in the list using XPath `//div[contains(., 'John Doe')]`.

### Key Methods
| Method             | Purpose                                  |  
|--------------------|------------------------------------------|  
| `setUp()`          | Initializes WebDriver and waits.         |  
| `testAddContact()` | Tests contact creation and validation.   |  
| `tearDown()`       | Closes the browser post-test.            |  

### Issues & Fixes
| Issue                        | Symptom                                  | Solution                                  |  
|------------------------------|------------------------------------------|-------------------------------------------|  
| **Selenium Version Mismatch**| CDP warnings for Chrome 133.             | Added `selenium-devtools-v133:4.20.0`.    |  
| **Element Locator Mismatch** | `TimeoutException` with XPath `text()`.  | Updated XPath to `contains(., 'text')`.   |  
| **ChromeDriver Setup**       | Manual driver version conflicts.         | Integrated `WebDriverManager` automation. |  

---

## Notes
- **CDP Warnings**: Non-blocking; resolved by aligning Selenium dependencies.
- **Best Practices**: Use explicit waits and `WebDriverManager` for stable tests.

--- 

## Screenshots
| Description          | Image                                                              |  
|----------------------|--------------------------------------------------------------------|  
| Contact List View    | ![Contact List View](https://github.com/user-attachments/assets/405c37a7-d838-4a3d-bdd5-f89da629477c) |  
| Add Contact Form     | ![Add Contact Form](https://github.com/user-attachments/assets/ccde6110-f610-4b70-896a-9df1a7d3fc96) |  
| Profile Image Upload | ![Profile Image Upload](https://github.com/user-attachments/assets/edc5fb0c-c35b-49d6-b9c2-b6b67f70fc4c) |  
| Pagination Example   | ![Pagination Example](https://github.com/user-attachments/assets/664a39f3-aae3-4500-87e7-2361971936a7) |  


---


