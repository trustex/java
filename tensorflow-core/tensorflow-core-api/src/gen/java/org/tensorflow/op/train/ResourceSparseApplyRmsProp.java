/* Copyright 2018-2023 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
=======================================================================*/

// This class has been generated, DO NOT EDIT!

package org.tensorflow.op.train;

import java.util.Arrays;
import org.tensorflow.GraphOperation;
import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.RawOpInputs;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.OpInputsMetadata;
import org.tensorflow.op.annotation.OpMetadata;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.proto.DataType;
import org.tensorflow.types.family.TNumber;
import org.tensorflow.types.family.TType;

/**
 * Update '*var' according to the RMSProp algorithm.
 * Note that in dense implementation of this algorithm, ms and mom will
 * update even if the grad is zero, but in this sparse implementation, ms
 * and mom will not update in iterations during which the grad is zero.
 * <p>mean_square = decay * mean_square + (1-decay) * gradient ** 2
 * Delta = learning_rate * gradient / sqrt(mean_square + epsilon)
 * <p>ms &lt;- rho * ms_{t-1} + (1-rho) * grad * grad
 * mom &lt;- momentum * mom_{t-1} + lr * grad / sqrt(ms + epsilon)
 * var &lt;- var - mom
 */
@OpMetadata(
    opType = ResourceSparseApplyRmsProp.OP_NAME,
    inputsClass = ResourceSparseApplyRmsProp.Inputs.class
)
@Operator(
    group = "train"
)
public final class ResourceSparseApplyRmsProp extends RawOp {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "ResourceSparseApplyRMSProp";

  public ResourceSparseApplyRmsProp(Operation operation) {
    super(operation, OP_NAME);
  }

  /**
   * Factory method to create a class wrapping a new ResourceSparseApplyRMSProp operation.
   *
   * @param scope current scope
   * @param var Should be from a Variable().
   * @param ms Should be from a Variable().
   * @param mom Should be from a Variable().
   * @param lr Scaling factor. Must be a scalar.
   * @param rho Decay rate. Must be a scalar.
   * @param momentum The momentum value
   * @param epsilon Ridge term. Must be a scalar.
   * @param grad The gradient.
   * @param indices A vector of indices into the first dimension of var, ms and mom.
   * @param options carries optional attribute values
   * @param <T> data type for {@code ResourceSparseApplyRMSProp} output and operands
   * @return a new instance of ResourceSparseApplyRmsProp
   */
  @Endpoint(
      describeByClass = true
  )
  public static <T extends TType> ResourceSparseApplyRmsProp create(Scope scope,
      Operand<? extends TType> var, Operand<? extends TType> ms, Operand<? extends TType> mom,
      Operand<T> lr, Operand<T> rho, Operand<T> momentum, Operand<T> epsilon, Operand<T> grad,
      Operand<? extends TNumber> indices, Options... options) {
    OperationBuilder opBuilder = scope.opBuilder(OP_NAME, "ResourceSparseApplyRmsProp");
    opBuilder.addInput(var.asOutput());
    opBuilder.addInput(ms.asOutput());
    opBuilder.addInput(mom.asOutput());
    opBuilder.addInput(lr.asOutput());
    opBuilder.addInput(rho.asOutput());
    opBuilder.addInput(momentum.asOutput());
    opBuilder.addInput(epsilon.asOutput());
    opBuilder.addInput(grad.asOutput());
    opBuilder.addInput(indices.asOutput());
    if (options != null) {
      for (Options opts : options) {
        if (opts.useLocking != null) {
          opBuilder.setAttr("use_locking", opts.useLocking);
        }
      }
    }
    return new ResourceSparseApplyRmsProp(opBuilder.build());
  }

  /**
   * Sets the useLocking option.
   *
   * @param useLocking If {@code True}, updating of the var, ms, and mom tensors is protected
   * by a lock; otherwise the behavior is undefined, but may exhibit less
   * contention.
   * @return this Options instance.
   */
  public static Options useLocking(Boolean useLocking) {
    return new Options().useLocking(useLocking);
  }

  /**
   * Optional attributes for {@link org.tensorflow.op.train.ResourceSparseApplyRmsProp}
   */
  public static class Options {
    private Boolean useLocking;

    private Options() {
    }

    /**
     * Sets the useLocking option.
     *
     * @param useLocking If {@code True}, updating of the var, ms, and mom tensors is protected
     * by a lock; otherwise the behavior is undefined, but may exhibit less
     * contention.
     * @return this Options instance.
     */
    public Options useLocking(Boolean useLocking) {
      this.useLocking = useLocking;
      return this;
    }
  }

  @OpInputsMetadata(
      outputsClass = ResourceSparseApplyRmsProp.class
  )
  public static class Inputs<T extends TType> extends RawOpInputs<ResourceSparseApplyRmsProp> {
    /**
     * Should be from a Variable().
     */
    public final Operand<? extends TType> var;

    /**
     * Should be from a Variable().
     */
    public final Operand<? extends TType> ms;

    /**
     * Should be from a Variable().
     */
    public final Operand<? extends TType> mom;

    /**
     * Scaling factor. Must be a scalar.
     */
    public final Operand<T> lr;

    /**
     * Decay rate. Must be a scalar.
     */
    public final Operand<T> rho;

    /**
     * The momentum input
     */
    public final Operand<T> momentum;

    /**
     * Ridge term. Must be a scalar.
     */
    public final Operand<T> epsilon;

    /**
     * The gradient.
     */
    public final Operand<T> grad;

    /**
     * A vector of indices into the first dimension of var, ms and mom.
     */
    public final Operand<? extends TNumber> indices;

    /**
     * The T attribute
     */
    public final DataType T;

    /**
     * The Tindices attribute
     */
    public final DataType Tindices;

    /**
     * If `True`, updating of the var, ms, and mom tensors is protected
     * by a lock; otherwise the behavior is undefined, but may exhibit less
     * contention.
     */
    public final boolean useLocking;

    public Inputs(GraphOperation op) {
      super(new ResourceSparseApplyRmsProp(op), op, Arrays.asList("T", "Tindices", "use_locking"));
      int inputIndex = 0;
      var = (Operand<? extends TType>) op.input(inputIndex++);
      ms = (Operand<? extends TType>) op.input(inputIndex++);
      mom = (Operand<? extends TType>) op.input(inputIndex++);
      lr = (Operand<T>) op.input(inputIndex++);
      rho = (Operand<T>) op.input(inputIndex++);
      momentum = (Operand<T>) op.input(inputIndex++);
      epsilon = (Operand<T>) op.input(inputIndex++);
      grad = (Operand<T>) op.input(inputIndex++);
      indices = (Operand<? extends TNumber>) op.input(inputIndex++);
      T = op.attributes().getAttrType("T");
      Tindices = op.attributes().getAttrType("Tindices");
      useLocking = op.attributes().getAttrBool("use_locking");
    }
  }
}
