package com.kingidee.kotlingraphql

import com.kingidee.kotlingraphql.repository.ReviewRepository
import com.kingidee.kotlingraphql.repository.SnackRepository
import com.kingidee.kotlingraphql.resolvers.ReviewMutationResolver
import com.kingidee.kotlingraphql.resolvers.ReviewQueryResolver
import com.kingidee.kotlingraphql.resolvers.SnackMutationResolver
import com.kingidee.kotlingraphql.resolvers.SnackQueryResolver
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.core.MongoOperations

@SpringBootApplication
class KotlinGraphQlApplication

fun main(args: Array<String>) {
	runApplication<KotlinGraphQlApplication>(*args)
}

@Bean
fun snackQuery(snackRepository: SnackRepository,mongoOperations: MongoOperations): SnackQueryResolver {
	return SnackQueryResolver(snackRepository,mongoOperations)
}

@Bean
fun reviewQuery(mongoOperations: MongoOperations): ReviewQueryResolver {
	return ReviewQueryResolver(mongoOperations)
}

@Bean
fun snackMutation(snackRepository: SnackRepository): SnackMutationResolver {
	return SnackMutationResolver(snackRepository)
}

@Bean
fun reviewMutation(reviewRepository: ReviewRepository): ReviewMutationResolver {
	return ReviewMutationResolver(reviewRepository)
}

