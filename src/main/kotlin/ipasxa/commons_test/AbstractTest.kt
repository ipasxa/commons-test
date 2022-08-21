package ipasxa.commons_test

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator
import java.util.UUID
import java.util.concurrent.atomic.AtomicLong
import javax.validation.Validation

private fun getValidatorFactory() = Validation.byDefaultProvider()
    .configure()
    .messageInterpolator(ParameterMessageInterpolator())
    .buildValidatorFactory()

abstract class AbstractTest {

    private val idGenerator = AtomicLong(100L)

    protected fun nextLongIdentifier() = idGenerator.incrementAndGet()

    protected fun randomString() = UUID.randomUUID().toString()

    protected fun javaxValidator() = getValidatorFactory().use { it.validator }

}