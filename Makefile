
.PHONY: all

all: build run

init:
	git config core.hooksPath .githooks

build:
	@mvn package
	@echo ""

run:
	@java -cp target/decide-1.0-SNAPSHOT.jar com.group23.decide.Decide

