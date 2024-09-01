#!/bin/bash
java -jar target/wc-cli-1.0-jar-with-dependencies.jar "$@" > debug.log 2>&1
