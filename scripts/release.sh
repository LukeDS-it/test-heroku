#!/bin/bash
if [ $TRAVIS_BRANCH = "master" ]; then
    git checkout master
    sbt release with-defaults
fi