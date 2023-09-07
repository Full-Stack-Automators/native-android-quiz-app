######################################################################
#  Zephyr base URL.
#  DON'T CHANGE THE CONSTANT BELOW. KEEP IT AS IT IS.
######################################################################
zephyrBaseUrl="https://api.zephyrscale.smartbear.com/v2/automations/executions"

#######################################################################
#  Access and secret keys, and user id needed for connection to Zephyr for Jira.
#  Replace the constants below with values relevant to your project and account.
#######################################################################

# The accessKey and secretKey to access your project. You can find them in your Jira Account settings: Profile picture > Zephyr Scale API Access Token > Create Access Token.
bearerToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL2Z1bGxzdGFja2F1dG9tYXRvcnMuYXRsYXNzaWFuLm5ldCIsInVzZXIiOnsiYWNjb3VudElkIjoiNzEyMDIwOjhkNjE5ZWM2LTNhNjUtNDk4ZS04YmM2LTIwY2I4ODMwYmUzYiJ9fSwiaXNzIjoiY29tLmthbm9haC50ZXN0LW1hbmFnZXIiLCJzdWIiOiI5MjUyZWYwMC03NzQ4LTNlYzctODcyYi04MjNjYzFhY2Q2MzAiLCJleHAiOjE3MjUxMTA2NzYsImlhdCI6MTY5MzU3NDY3Nn0.XZ0YRGEmFcY4R94hfsr8owDJISoRK7i6g4RdtSEH7Fc"

#######################################################################
#  Define properties of the automation task.
#  Replace the values below with data relevant to your project.
#######################################################################

projectKey="MA"
xmlPath="@//Users/Jace/repo/native-android-quiz-app/app/build/outputs/androidTest-results/connected/TEST-Copy_of_Pixel_6_API_31(AVD) - 12-app-.xml"
autoCreateTestCases="true"

#######################################################################
#  Create an automation task, run it, send test results to Zephyr.
#  Keep this section as it is.
#######################################################################
echo "Uploading test results to Zephyr Scale..."
curl -H "Authorization: Bearer $bearerToken" -F "file=$xmlPath;type=application/xml" "$zephyrBaseUrl/junit?projectKey=$projectKey&autoCreateTestCases=$autoCreateTestCases"
