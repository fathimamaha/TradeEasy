# Stage 1: Compile and Build angular codebase

# Use official node image as the base image
FROM node:14.15.1 as build

# Set the working directory
WORKDIR /usr/local/app

# Add the source code to app
COPY ./ /usr/local/app/

# Install all the dependencies
RUN npm install

# Generate the build of the application
RUN npm run build

# For logging print the name of the generated dir
RUN ls /usr/local/app/dist


# Stage 2: Serve app with nginx server

# Use nginx unprivileged (non-root) image as the base image
FROM nginxinc/nginx-unprivileged

# Copy the build output to replace the default nginx contents.
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/local/app/dist/TradersApp/ /usr/share/nginx/html

# Expose port 80
EXPOSE 8080
CMD ["nginx", "-g", "daemon off;"]
