FROM common-docker-r.eu.artifactory.conti.de/golang:latest as builder

COPY . /build
WORKDIR /build
RUN go build -o dtc .
RUN go get golang.org/x/lint/golint \
&& go get github.com/jstemmer/go-junit-report
RUN golint ./... >result-golint.txt
RUN go vet ./... 2>&1 | tee result-govet.txt
RUN go test -v ./... | go-junit-report >result-gotest.xml

FROM common-docker-r.eu.artifactory.conti.de/debian:stable-slim
RUN apt-get -y update && apt-get -y install ca-certificates
COPY --from=builder /build/dtc /usr/bin/

CMD ["/usr/bin/dtc"]

