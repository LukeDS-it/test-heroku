# Heroku Scaffold
[![Build Status](https://travis-ci.com/LukeDS-it/test-heroku.svg?branch=master)](https://travis-ci.com/LukeDS-it/test-heroku)
[ ![Download](https://api.bintray.com/packages/lukeds-it/maven/test-heroku-api/images/download.svg) ](https://bintray.com/lukeds-it/maven/test-heroku-api/_latestVersion)
 
This is a scaffold to create applications for the heroku platform.

## Versions

* Scala 2.12.7
* SBT 1.2.6

## What's inside
You will find two sub-projects:

* API, an empty project out of the box, which is made to contain services definitions
* SERVER, the executable bit. It's made with finagle-http to keep everything basic. In the future, other branches will
  be added with support to other frameworks.
  
  
The project is already configured to support travis-ci with a github repository. Please refer to the various guides to
see how to set up the CI in your heroku app.

The project is already configured to produce a jar that can be run in heroku's platform.

## How to use
To use this scaffold, fork the repository and make adjustments to the build.sbt as you see fit.