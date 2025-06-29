POSTMAN COLLECTION - https://drive.google.com/file/d/1ErHQaNppJrYdJ9pn0Y0-9gfAK9lPuO21/view?usp=sharing


## Identity Verification Service API

### Overview
A RESTful API for verifying Nigerian identity documents (BVN and NIN) with detailed personal information retrieval.  
Provides secure identity verification for financial and KYC processes.

---

### Key Features

- BVN (Bank Verification Number) verification
- NIN (National Identity Number) verification
- Detailed personal information retrieval
- Residential and origin information
- Secure API key authentication

---

### Authentication

All endpoints require API key authentication.

**Header:**  
X-API-KEY: your-secret-key

---

### API Endpoints

#### 1. BVN Verification

**Endpoint:**  
POST /api/identity/bvn

**Headers:**  
X-API-KEY: secure-key-12345  
Content-Type: application/json

**Request Body:**
{
  "number": "59220822994"
}

**Success Response:**
{
  "statusCode": "200",
  "status": "Success",
  "message": "BVN Verification Completed Successfully",
  "result": {
    "requestReference": "E5fAXe757848871_22",
    "bvnNumber": "59220822994",
    "nin": "60539994999",
    "verificationStatus": "VERIFIED",
    "personalInfo": {
      "firstName": "John",
      "middleName": "Job",
      "lastName": "Doe",
      "phoneNumber": "08034567892",
      "dateOfBirth": "07/08/1997"
    },
    "residentialInfo": {
      "residentialAddress": "lagos street",
      "stateOfResidence": "FCT"
    }
  }
}

**Error Response - Unauthorized:**
{
  "statusCode": "02",
  "status": "fail",
  "message": "Unauthorized"
}

**Error Response - Invalid BVN:**
{
  "statusCode": "02",
  "status": "fail",
  "message": "bvn is not valid"
}

---

#### 2. NIN Verification

**Endpoint:**  
POST /api/identity/nin

**Headers:**  
X-API-KEY: secure-key-12345  
Content-Type: application/json

**Request Body:**
{
  "number": "42937562241"
}

**Success Response:**
{
  "statusCode": "200",
  "status": "Success",
  "message": "NIN Verification Completed Successfully",
  "result": {
    "requestReference": "E5fAXe757848871_22",
    "ninNumber": "60539994999",
    "verificationStatus": "VERIFIED",
    "personalInfo": {
      "firstName": "John",
      "middleName": "Job",
      "lastName": "Doe",
      "phoneNumber": "08034567892",
      "dateOfBirth": "07/08/1997"
    },
    "nextOfKin": {
      "firstname": "Kola",
      "surname": "Binuyo",
      "state": "Lagos State"
    },
    "indigeneInfo": {
      "stateOfOrigin": "Anambra State"
    }
  }
}

**Error Responses:**  
(Same format as BVN errors)

---

### Technical Implementation

#### Request Class

public class VerificationRequest {
    private String number; // BVN or NIN
}


## ⚙️ Configuration (`application.properties`)
properties
spring.application.name=identityservice
server.port=8096
app.secret-key=secure-key-12345


## Testing Valid Numbers

| Document Type | Valid Numbers                            |
|---------------|-------------------------------------------|
| **BVN**       | 59220822994, 59220822888, 70252300667     |
| **NIN**       | 42937562241, 42937562333, 93674303747     |

