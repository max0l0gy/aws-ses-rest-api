# Read Me First
The steps for building this project ant pull to kubernetes:

Test app:

docker build -t maxmorev/aws-ses-rest-api .

docker images
````
docker run  -p 8081:8080 \
-e AWS_ACCESS_KEY_ID='YOUR-ID' \
-e AWS_SECRET_ACCESS_KEY='YOUR-KEY' \
-e AWS_REGION='YOUR-REGION' \
--name aws-ses-rest-api
````
docker container exec -it aws-ses-rest-api sh

docker login

docker push maxmorev/aws-ses-rest-api

kubectl apply -f secret.yaml

kubectl get secret aws-secrets -o yaml

kubectl apply -f service.yaml

kubectl create deployment aws-ses-rest-api --image=maxmorev/aws-ses-rest-api

kubectl get pods
````
NAME                                READY   STATUS    RESTARTS   AGE
aws-ses-rest-api-66d8656456-wxrmw   1/1     Running   0          28s
aws-ses-rest-api-66d8656456-xpwnb   1/1     Running   0          28s

````
kubectl get svc 
````
NAME               TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)    AGE
aws-ses-rest-api   ClusterIP   10.245.164.220   <none>        8080/TCP   13m
````
Exece shell:

kubectl exec -t -i aws-ses-rest-api-66d8656456-wxrmw sh

