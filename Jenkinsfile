pipeline {
  agent any
  stages{
    stage('CheckOut') {
        steps {
          // 소스코드 체크아웃
          checkout scm
        }
    }
    
    stage('Build') {
      steps {
        script {
          // Java 파일들을 컴파일하여 생성된 클래스 파일을 classes 디렉토리에 저장
          // Window 일 경우 bat
          def classpath = "classes;C:\\Users\\jeeew\\eclipse\\plugins\\junit-platform-console-standalone-1.7.1.jar"

          bat 'javac -encoding UTF-8 -d classes practice_lab1/src/practice_lab1/Book.java'
          bat "javac -encoding UTF-8 -d test-classes -classpath ${classpath} practice_lab1/src/practice_lab1/BookPerformanceTest.java"
        }
      }
    }

    stage('Test') {
      steps{
        script {
          // JUnit 5 테스트 실행을 위한 classpath 설정
          def classpath = "classes;C:\\Users\\jeeew\\eclipse\\plugins\\junit-platform-console-standalone-1.7.1.jar"
          // JUnit 5 테스트 실행
          bat "java -cp ${classpath} org.junit.platform.console.ConsoleLauncher --scan-classpath > test_results.txt"
        }

      }
    }
  }
  
  post {
    always {
      //테스트 결과 파일을 저장하기 위해 아카이브
      archiveArtifacts artifacts: 'test_result.txt', allowEmptyArchive: true
    }
    failure {
      echo 'Build or test Failed'

    }
    success {
      echo 'Build and test Succeeded'
    }
  }
}

