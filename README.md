# Google OAuth2 Authentication Demo

A simple Spring Boot application demonstrating Google OAuth2 authentication integration. This application allows users to sign in with their Google account and displays their profile information including name, email, and profile picture.

## Features

- Google OAuth2 authentication
- User profile information display
- Secure session management
- Responsive UI design
- Logout functionality

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Google Cloud Platform account
- Google OAuth2 credentials (Client ID and Client Secret)

## Setup Instructions

### 1. Google Cloud Platform Setup

1. Go to [Google Cloud Console](https://console.cloud.google.com/)
2. Create a new project or select an existing one
3. Enable the Google+ API
4. Navigate to Credentials
5. Create OAuth 2.0 Client ID
6. Configure the OAuth consent screen
7. Add authorized redirect URI: `http://localhost:8080/login/oauth2/code/google`
8. Copy your Client ID and Client Secret

### 2. Application Configuration

1. Clone the repository
2. Create a file `src/main/resources/application-local.yml` with the following content:
```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: YOUR_CLIENT_ID
            client-secret: YOUR_CLIENT_SECRET
            scope:
              - email
              - profile

server:
  port: 8080
```

Replace `YOUR_CLIENT_ID` and `YOUR_CLIENT_SECRET` with your actual Google OAuth2 credentials.

### 3. Running the Application

1. Open a terminal in the project root directory
2. Run the following command:
```bash
mvn spring-boot:run
```
3. Open your browser and navigate to `http://localhost:8080`

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── authCheck/
│   │           └── oAuthCheck/
│   │               ├── controller/
│   │               │   └── AuthController.java
│   │               └── config/
│   │                   └── SecurityConfig.java
│   └── resources/
│       ├── templates/
│       │   ├── login.html
│       │   └── success.html
│       └── application.yml
```

## Dependencies

- Spring Boot 3.2.3
- Spring Security
- Spring OAuth2 Client
- Thymeleaf
- Spring Web

## Security Features

- CSRF protection
- Secure session management
- HTTPS enforcement for OAuth2 endpoints
- Protected routes requiring authentication

## Troubleshooting

1. If the profile picture is not displaying:
   - Check the browser console for any errors
   - Verify the picture URL in the debug information section
   - Ensure the Google account has a profile picture

2. If authentication fails:
   - Verify your Google OAuth2 credentials
   - Check if the redirect URI matches exactly
   - Ensure the Google+ API is enabled

## Contributing

Feel free to submit issues and enhancement requests!
