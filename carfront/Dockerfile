FROM node:lts-slim
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . .
EXPOSE 3000
RUN npm install

CMD [ "npm", "start" ]