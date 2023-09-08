######################################################################
#  This .sh file demonstrates how to create or update an automation task in Zephyr for Jira Cloud, run this task, and publish test results to Zephyr.
#  Author: SmartBear Software
######################################################################

######################################################################
#  Zephyr base URL.
#  DON'T CHANGE THE CONSTANT BELOW. KEEP IT AS IT IS.
######################################################################
zephyrBaseUrl="https://prod-api.zephyr4jiracloud.com/connect"

#######################################################################
#  Access and secret keys, and user id needed for connection to Zephyr for Jira.
#  Replace the constants below with values relevant to your project and account.
#######################################################################

# The accessKey and secretKey to access your project. You can find them in your Jira project: Zephyr > API Keys.
accessKey="Y2RjYTAwMTItNDhkZS0zODllLWJmODEtZTQ3NmFjNGI2YTQ4IDcxMjAyMCUzQWYxNzRmZGY2LWVjZTctNDVlNC1hYmJkLWI0NThlMDA3ZTdkZSBVU0VSX0RFRkFVTFRfTkFNRQ"
secretKey="BlRl0yICBS8NKfsu_dtRg4y3zUV3d7j9-_RGpdFUoeQ"
# Id of the user who will create the automation task. You can find it in Jira.
accountId="712020:f174fdf6-ece7-45e4-abbd-b458e007e7de"

#######################################################################
#  Create a JSON Web Token  (required to access Zephyr for Jira).
#  Keep this section as it is.
#######################################################################
echo "Generating a JSOM Web Token ... \n"
curl -o headers -s -d '{  "accessKey": "'"$accessKey"'"  , "secretKey": "'"$secretKey"'" ,"accountId": "'"$accountId"'","zephyrBaseUrl": "'"$zephyrBaseUrl"'","expirationTime":360000}' -H "Content-Type: application/json" -XPOST https://prod-vortexapi.zephyr4jiracloud.com/api/v1/jwt/generate
jwt="$(cat headers | head -n 1)"
echo "The generated token: \n"
echo $jwt

#######################################################################
#  Define properties of the automation task.
#  Replace the values below with data relevant to your project.
#######################################################################

# Task info
jobName="Android UI Tests"
jobDescription="Running Android UI Automation tests"
automationFramework="Junit"
projectKey="ZT"
versionName="Unscheduled"

# Cycle info
cycleName="EspressoTests"
createNewCycle="false"
appendDateTimeInCycleName="false"

# Folder info
folderName="RegressionTests"
createNewFolder="true"
appendDateTimeInFolderName="true"
assigneeUser="712020:f174fdf6-ece7-45e4-abbd-b458e007e7de"
mandatoryFields="{\"reporter\":{\"label\":\"Jace Parara\",\"name\":\"Jace Parara\",
                \"id\":\"712020:f174fdf6-ece7-45e4-abbd-b458e007e7de\"}}"

# Name of the test result file
resultPath="@//$HOME/repo/native-android-quiz-app/app/build/outputs/androidTest-results/connected/TEST-Copy_of_Pixel_6_API_31(AVD) - 12-app-.xml"

#######################################################################
#  Create an automation task, run it, send test results to Zephyr.
#  Keep this section as it is.
#######################################################################
echo "Creating and running an automation task ..."
curl -o headers -s -v -H "accessKey: $accessKey" -H "jwt: $jwt" -H "Content-Type: multipart/form-data" -H "Content-Type: application/json" -F "jobName=$jobName" -F "jobDescription=$jobDescription" -F "automationFramework=$automationFramework" -F "projectKey=$projectKey" -F "versionName=$versionName" -F "cycleName=$cycleName" -F "createNewCycle=$createNewCycle" -F "appendDateTimeInCycleName=$appendDateTimeInCycleName" -F "folderName=$folderName" -F "createNewFolder=$createNewFolder" -F "appendDateTimeInFolderName=$appendDateTimeInFolderName" -F "assigneeUser=$assigneeUser" -F "file=$resultPath" -F "mandatoryFields=$mandatoryFields" -XPOST https://prod-vortexapi.zephyr4jiracloud.com/api/v1/automation/job/saveAndExecute
result="$(cat headers | head -n 1)"
echo "Test results: \n"
echo $result
