FROM openjdk:8

RUN mkdir /artifact
RUN cd artifact

WORKDIR /artifact
RUN apt update
RUN apt install curl

RUN apt-get install -y libxrender1 libxtst6 libxi6
RUN apt install  p7zip-full

RUN curl -L -H "Accept: application/vnd.github.v3+json" -H "Authorization:token <MYTOKEN> >" https://api.github.com/repos/PierCloud/JCalculator/actions/artifacts/1368273515/zip --output j.zip

RUN 7z e j.zip

CMD ["java", "-jar", "JCalculator-1.0-SNAPSHOT.jar"]