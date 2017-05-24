grails.project.work.dir = 'target/work'

grails.project.dependency.resolver = 'maven'
grails.project.dependency.resolution = {
    inherits 'global'
    log 'error'
    checksums true
    legacyResolve false

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        // Latest httpmime for Coveralls plugin
        build 'org.apache.httpcomponents:httpmime:4.5.2'
        build ('org.kuali.maven.wagons:maven-s3-wagon:1.2.1') {
            export = false
            exclude 'slf4j-log4j12'
        }
        
        // AWS SDK lib
        compile 'com.amazonaws:aws-java-sdk:1.11.117'
    }

    plugins {
        build(':release:3.1.1',
              ':rest-client-builder:2.1.1',
              ':coveralls:0.1') {
            export = false
        }
        test(':code-coverage:2.0.3-3') {
            export = false
        }
    }
}
