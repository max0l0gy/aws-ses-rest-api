aws ses update-template --cli-input-json file://verify.json
http POST :8888/send/template/ < EmailRequest.json
aws ses create-template --cli-input-json file://ses-templates/reset-password.json
aws ses send-templated-email --cli-input-json file://mailsend.json
aws configure
