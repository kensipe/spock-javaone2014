import com.example.Fast
import com.example.Slow


runner {
    exclude {
        annotation Slow
    }
}


/*

runner {
    include Fast
    filterStackTrace true
}

runner {
    exclude {
        baseClass FastAndSlowSpec
    }
}


     runner {
        filterStackTrace true
        include
        exclude
        optimizeRunOrder
    }

    include Fast // could be either an annotation or a (base) class
       exclude {
         annotation some.pkg.Slow
         baseClass IntegrationSpec
       }
 */