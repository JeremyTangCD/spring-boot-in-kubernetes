# Spring-Boot-In-Kubernetes
This project construct several spring boot servers in kubernetes.

The nginx ingress is used as the load balancer.

The rule for load balancing is **consistent hashing** base on $request_uri. 

The configuration can be got in https://kubernetes.github.io/ingress-nginx/user-guide/nginx-configuration/annotations/

### Guides

1. Make sure the **docker, kubernetes, kubectl, helm chart** are installed
2. Add the **NGINX Ingress Controller** as below (in docker for mac, other envs pls check https://kubernetes.github.io/ingress-nginx/deploy/)
```
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/mandatory.yaml
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/provider/cloud-generic.yaml
```
3. Add the helm tiller to the kubernetes
```
kubectl create serviceaccount tiller --namespace kube-system
kubectl create clusterrolebinding tiller --clusterrole cluster-admin --serviceaccount=kube-system:tiller
helm init --service-account=tiller
```
4. Use helm to deploy this project
```
helm upgrade --install --tiller-namespace="kube-system" helloworld chart/helloworld/
```
5. Use the request below to check whether the servers are avaliable
```
curl -G "http://localhost?a=2
```
6. The result below means the deployment is successful.
```
Hello Docker World helloworld-75b55c4dd-4rdjr
```
