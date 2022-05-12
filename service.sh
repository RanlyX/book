#!/bin/bash

BUILD_PATH="./build/libs"
WAR_NAME="app.war"
TARGET="$BUILD_PATH/$WAR_NAME"
SERVICE_IMG="book_web"
SERVICE_NAME="book-web-1"

## Build java web app
build() {
    ./gradlew war
}

## Clean
cleanOptions() {
    while [[ $# -gt 0 ]]; do
        local opt=$1
        shift
        case $opt in
            -c)
                cleanContainer
                break
                ;;
            -i)
                cleanImage
                break
                ;;
            -t)
                cleanTarget
                break
                ;;
            -a)
                cleanAll
                break
                ;;
            ?)
                usage
                exit
                ;;
        esac
    done
}

cleanTarget() {
    rm -f $TARGET
}

cleanImage() {
    cleanContainer
    docker rmi SERVICE_IMG
}

cleanContainer() {
    stopService
}

cleanAll() {
    cleanImage
    cleanTarget
}

## Service control
### Run
runOptions() {
    while [[ $# -gt 0 ]]; do
        local opt=$1
        shift
        case $opt in
            -b)
                buildRunService
                break
                ;;
            ?)
                usage
                exit
                ;;
        esac
    done
    runService
}

runService() {
    if [ ! -f $TARGET ]; then
        build
    fi
    local args=$1
    docker-compose up $args -d
}

buildRunService() {
    runService "--build"
}

### Stop
stopService() {
    docker-compose down
}

usage() {
    echo "Usage: service.sh [COMMAND] [OPTIONS]"
    echo ""
    echo "  * is for COMMAND, . is for OPTIONS"
    echo ""
    echo "  * run, will run service"
    echo "     . -b, --build to rebuild image"
    echo "  * stop, will stop service"
    echo "  * clean, will remove"
    echo "     . -t, --target to remove target"
    echo "     . -i, --image to remove image"
    echo "     . -c, --container remove container"
    echo "     . -a, --all remove all"
    echo " * help, -h, --help show usage"
    echo ""
}

main() {
    local cmd=$1
    shift
    echo $@
    echo "***** $cmd *****"
    if [[ $cmd == "run" ]]; then
        runOptions $@
    elif [[ $cmd == "stop" ]]; then
        stopService
    elif [[ $cmd == "clean" ]]; then
        cleanOptions $@
    else
        usage
    fi
}

main $@