node {
    def mvnHome
    mvnHome = tool 'Maven_3_6_0'
    stage('Fetch sources and build sources') {
        //get sources
        git 'https://github.com/steevessaillant/TDDJavaValueInverterKataNoSpringBoot'
        //maven compile
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' compile "
        } else {
            bat(/"${mvnHome}\bin\mvn" compile/)
        }

    }

    step([$class: 'XUnitBuilder', testTimeMargin: '3000', thresholdMode: 1,
          thresholds: [
                  [$class: 'FailedThreshold', failureNewThreshold: '', failureThreshold: '', unstableNewThreshold: '', unstableThreshold: '1'],
                  [$class: 'SkippedThreshold', failureNewThreshold: '', failureThreshold: '', unstableNewThreshold: '', unstableThreshold: '']],
          tools: [
                  [$class: 'JUnitType', deleteOutputFiles: false, failIfNotNew: false, pattern: 'reports/**', skipNoTestFiles: false, stopProcessingIfError: true]]
    ])
/*
    stage('Unit Tests') {
        //maven test
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' test "
        } else {
            bat(/"${mvnHome}\bin\mvn" test/)
        }

    }
*/
    stage('JUnit unit-test report'){
        always {
                junit '**/surefire-reports/*.xml'
              }
    }

   stage('Functional Tests') {
        //maven test
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' failsafe:integration-test"
        } else {
            bat(/"${mvnHome}\bin\mvn" failsafe:integration-test/)
        }

    }
    stage('Cucumber functional tests report') {
            cucumber buildStatus: 'UNSTABLE',
                    fileIncludePattern: '**/cucumber.json',
                    trendsLimit: 10,
                    classifications: [
                        [
                            'key': 'Browser',
                            'value': 'Chrome'
                        ]
                    ]
        }
    stage('Deploy') {

        //maven compile
        //if (isUnix()) {
        //    sh "'${mvnHome}/bin/mvn' package "
        //} else {
        //    bat(/"${mvnHome}\bin\mvn" package/)
        //}
        echo "This stage is commented out for now!"
    }
}

