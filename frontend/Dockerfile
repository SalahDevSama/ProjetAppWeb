# Build de l'application Vue.js
FROM node:lts-alpine as build-stage

# On se place dans le dossier de travail
WORKDIR /app

# On copie les fichiers de dépendances
COPY package*.json ./

# On installe les dépendances
RUN npm install

# On copie tout le reste du code source
COPY . .

# On lance la compilation (crée le dossier /dist)
RUN npm run build

# ÉTAPE 2 : Mise en place du serveur de production Nginx
FROM nginx:stable-alpine as production-stage

# On copie la configuration Nginx qu'on a créée
COPY nginx.conf /etc/nginx/conf.d/default.conf

# On copie les fichiers compilés de l'étape 1 vers le dossier de Nginx
COPY --from=build-stage /app/dist /usr/share/nginx/html

# On expose le port 80 (standard web)
EXPOSE 80

# On lance Nginx
CMD ["nginx", "-g", "daemon off;"]