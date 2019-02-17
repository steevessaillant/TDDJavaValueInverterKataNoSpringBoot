node {
    def mvnHome
    mvnHome = tool 'Maven_3_6_0'
    stage('Fetch sources and build sources') {
        //get sources
        git 'https://github.com/steevessaillant/TDDJavaValueInverterKata'
        //maven compile
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' compile "
        } else {
            bat(/"${mvnHome}\bin\mvn" compile/)
        }

    }

    stage('Test') {
        //maven test
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' test "
        } else {
            bat(/"${mvnHome}\bin\mvn" test/)
        }

    }

    stage('JUnit unit-test report'){
        always {
                junit '**/surefire-reports/*.xml'
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

