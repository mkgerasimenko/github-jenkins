node {
    try {
        stage('Checkout source code to master') {
            checkout scm
        }
        stage('Run quality checks and tests') {
            bat './gradlew clean check'
        }
        stage('Publish Allure report') {
            publish.allureReport()
        }
    } finally {
        checkstyle pattern: 'build/reports/checkstyle/main.xml'
        pmd pattern: 'build/reports/pmd/main.xml'
        findbugs pattern: 'build/reports/findbugs/main.xml'
    }
}
