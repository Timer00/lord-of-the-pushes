FROM nginx:1.19.10-alpine

ARG PASSWORD="qwe123qwe"
ENV PASSWORD=${PASSWORD}

RUN apk add openssl

RUN mkdir -p /etc/nginx/certs

WORKDIR /etc/nginx/certs

RUN openssl genrsa -des3 --passout pass:${PASSWORD} -out lordofthepushes.local.key 2048

RUN openssl rsa -in lordofthepushes.local.key -passin pass:${PASSWORD} -out lordofthepushes.local.key

RUN cp lordofthepushes.local.key lordofthepushes.local.key_pass

RUN openssl rsa -in lordofthepushes.local.key_pass -out lordofthepushes.local.key

RUN openssl req -new -key lordofthepushes.local.key -out lordofthepushes.local.csr -passin pass:${PASSWORD} \
    -subj "/C=BR/ST=PR/L=CWB/O=LordOfThePushes/OU=LOTP/CN=lordofthepushes.local/emailAddress=viniciusmarc_@hotmail.com"

RUN openssl x509 -req -days 3650 -in lordofthepushes.local.csr -signkey lordofthepushes.local.key -out lordofthepushes.local.crt

WORKDIR /etc/nginx

ENTRYPOINT ["nginx", "-g", "daemon off;"]