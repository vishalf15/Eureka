Eureka config server with its client.

Features
Port details
Commands
Important properties details


Features

	1. Local properties repo
	2. Git properties repo
	3. encrypted Git password
	4. Dynamic properties reloading at client side

---------------------------------------------------------------------------------------------------------------------

Ports
	Config Server port = 8888

	Config Client port = 8080

---------------------------------------------------------------------------------------------------------------------

Commands

	Genrate KeyStore -
		keytool -genkeypair -alias mytestkey3 -keyalg RSA -keypass changeme3 -keystore server3.jks -storepass letmein3

	Dynamic reloading of properties at client side -
		curl localhost:8080/refresh -d {} -H "Content-Type: application/json"

	Create encrypted password -
		curl -X POST --data-urlencode d3v3L http://root:s3cr3t@localhost:8888/encrypt
	
	
---------------------------------------------------------------------------------------------------------------------

Important properties details

	config-server/application.properties
		spring.application.name 	=	Name of your config server
		server.port					=	Port on which Config Server will run. Same port need to configure in client
		security.user.name			=	Username which will be used by client to communicate with 'Config Server'
		security.user.password		=	Password which will be used by client to communicate with 'Config Server'
		
	config-server/bootstrap.properties
		encrypt.keyStore.location	=	location of keystore in project
		encrypt.keyStore.password	=	Keystore password
		encrypt.keyStore.alias		=	KeyStore alias
		encrypt.keyStore.secret		=	KeyStore secret
		
		spring.cloud.config.server.git.uri		=	Git repo details. If repo is locally located then use 'file://<PATH_TO_REPO_FOLDER>
		spring.cloud.config.server.git.username	=	Git repo username
		spring.cloud.config.server.git.password	=	Git repo password. If password is encrypted then use '{cipher}' prefix
		