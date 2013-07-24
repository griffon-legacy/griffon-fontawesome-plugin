griffon.project.dependency.resolution = {
    inherits "global"
    log "warn"
    repositories {
        griffonHome()
        mavenRepo 'http://repository.sonatype.org/content/groups/public'
    }
    dependencies {
        build   'org.webjars:font-awesome:3.2.1'
        compile 'org.webjars:font-awesome:3.2.1'
    }
}

log4j = {
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

    error 'org.codehaus.griffon',
          'org.springframework',
          'org.apache.karaf',
          'groovyx.net'
    warn  'griffon'
}