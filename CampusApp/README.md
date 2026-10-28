# Campus App - Android Assignment 2

An Android app (Java + XML) with the common screens found in most apps.
All data is hardcoded, so no backend is needed.

## Features
- **Splash screen** with logo and app name. It opens Login after 2 seconds, or when you tap it.
- **Login** with email and password validation, plus Register and Forgot Password links.
- **Register** with name, email, password and confirm password validation.
- **Forgot Password** accepts an email and starts a simulated recovery.
- **Reset Password** with new password and confirm password validation.
- **Dashboard** with a 2x2 grid of cards (icon + text): Courses, Schedule, Notifications, Profile.
- **Profile** shows the user's name and email, with a Logout button.
- **Light and dark mode** using `values/colors.xml` and `values-night/colors.xml`.
- **All text** is stored in `strings.xml`.

## Layouts Used
| Layout | Screens |
|---|---|
| LinearLayout | Login, Forgot Password |
| GridLayout | Dashboard |
| ConstraintLayout | Splash, Register, Reset Password, Profile |

## Navigation Flow
```
Splash -> Login -> Dashboard -> Profile -> Logout -> Login
Login -> Register -> Login
Login -> Forgot Password -> Reset Password -> Login
```
All screen changes use **explicit Intents**.

## Test Account
- Email: `student@test.com`
- Password: `123456`

## Input Types
- `textEmailAddress` for email fields
- `textPassword` for password fields
- `textPersonName` for the name field

## How to Run
1. Open the project folder in Android Studio.
2. Wait for Gradle sync to finish.
3. Run on an emulator or a real phone.
4. To test dark mode, turn on Dark theme in the device settings.

## Tech
Java, XML, Android Studio, Material Components. Min SDK 24.
