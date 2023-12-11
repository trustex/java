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
import org.tensorflow.types.family.TType;

/**
 * Update '*var' according to the momentum scheme.
 * Set use_nesterov = True if you want to use Nesterov momentum.
 * <p>accum = accum * momentum - lr * grad
 * var += accum
 */
@OpMetadata(
    opType = ResourceApplyKerasMomentum.OP_NAME,
    inputsClass = ResourceApplyKerasMomentum.Inputs.class
)
@Operator(
    group = "train"
)
public final class ResourceApplyKerasMomentum extends RawOp {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "ResourceApplyKerasMomentum";

  public ResourceApplyKerasMomentum(Operation operation) {
    super(operation, OP_NAME);
  }

  /**
   * Factory method to create a class wrapping a new ResourceApplyKerasMomentum operation.
   *
   * @param scope current scope
   * @param var Should be from a Variable().
   * @param accum Should be from a Variable().
   * @param lr Scaling factor. Must be a scalar.
   * @param grad The gradient.
   * @param momentum Momentum. Must be a scalar.
   * @param options carries optional attribute values
   * @param <T> data type for {@code ResourceApplyKerasMomentum} output and operands
   * @return a new instance of ResourceApplyKerasMomentum
   */
  @Endpoint(
      describeByClass = true
  )
  public static <T extends TType> ResourceApplyKerasMomentum create(Scope scope,
      Operand<? extends TType> var, Operand<? extends TType> accum, Operand<T> lr, Operand<T> grad,
      Operand<T> momentum, Options... options) {
    OperationBuilder opBuilder = scope.opBuilder(OP_NAME, "ResourceApplyKerasMomentum");
    opBuilder.addInput(var.asOutput());
    opBuilder.addInput(accum.asOutput());
    opBuilder.addInput(lr.asOutput());
    opBuilder.addInput(grad.asOutput());
    opBuilder.addInput(momentum.asOutput());
    if (options != null) {
      for (Options opts : options) {
        if (opts.useLocking != null) {
          opBuilder.setAttr("use_locking", opts.useLocking);
        }
        if (opts.useNesterov != null) {
          opBuilder.setAttr("use_nesterov", opts.useNesterov);
        }
      }
    }
    return new ResourceApplyKerasMomentum(opBuilder.build());
  }

  /**
   * Sets the useLocking option.
   *
   * @param useLocking If {@code True}, updating of the var and accum tensors will be protected
   * by a lock; otherwise the behavior is undefined, but may exhibit less
   * contention.
   * @return this Options instance.
   */
  public static Options useLocking(Boolean useLocking) {
    return new Options().useLocking(useLocking);
  }

  /**
   * Sets the useNesterov option.
   *
   * @param useNesterov If {@code True}, the tensor passed to compute grad will be
   * var + momentum * accum, so in the end, the var you get is actually
   * var + momentum * accum.
   * @return this Options instance.
   */
  public static Options useNesterov(Boolean useNesterov) {
    return new Options().useNesterov(useNesterov);
  }

  /**
   * Optional attributes for {@link org.tensorflow.op.train.ResourceApplyKerasMomentum}
   */
  public static class Options {
    private Boolean useLocking;

    private Boolean useNesterov;

    private Options() {
    }

    /**
     * Sets the useLocking option.
     *
     * @param useLocking If {@code True}, updating of the var and accum tensors will be protected
     * by a lock; otherwise the behavior is undefined, but may exhibit less
     * contention.
     * @return this Options instance.
     */
    public Options useLocking(Boolean useLocking) {
      this.useLocking = useLocking;
      return this;
    }

    /**
     * Sets the useNesterov option.
     *
     * @param useNesterov If {@code True}, the tensor passed to compute grad will be
     * var + momentum * accum, so in the end, the var you get is actually
     * var + momentum * accum.
     * @return this Options instance.
     */
    public Options useNesterov(Boolean useNesterov) {
      this.useNesterov = useNesterov;
      return this;
    }
  }

  @OpInputsMetadata(
      outputsClass = ResourceApplyKerasMomentum.class
  )
  public static class Inputs<T extends TType> extends RawOpInputs<ResourceApplyKerasMomentum> {
    /**
     * Should be from a Variable().
     */
    public final Operand<? extends TType> var;

    /**
     * Should be from a Variable().
     */
    public final Operand<? extends TType> accum;

    /**
     * Scaling factor. Must be a scalar.
     */
    public final Operand<T> lr;

    /**
     * The gradient.
     */
    public final Operand<T> grad;

    /**
     * Momentum. Must be a scalar.
     */
    public final Operand<T> momentum;

    /**
     * The T attribute
     */
    public final DataType T;

    /**
     * If `True`, updating of the var and accum tensors will be protected
     * by a lock; otherwise the behavior is undefined, but may exhibit less
     * contention.
     */
    public final boolean useLocking;

    /**
     * If `True`, the tensor passed to compute grad will be
     * var + momentum * accum, so in the end, the var you get is actually
     * var + momentum * accum.
     */
    public final boolean useNesterov;

    public Inputs(GraphOperation op) {
      super(new ResourceApplyKerasMomentum(op), op, Arrays.asList("T", "use_locking", "use_nesterov"));
      int inputIndex = 0;
      var = (Operand<? extends TType>) op.input(inputIndex++);
      accum = (Operand<? extends TType>) op.input(inputIndex++);
      lr = (Operand<T>) op.input(inputIndex++);
      grad = (Operand<T>) op.input(inputIndex++);
      momentum = (Operand<T>) op.input(inputIndex++);
      T = op.attributes().getAttrType("T");
      useLocking = op.attributes().getAttrBool("use_locking");
      useNesterov = op.attributes().getAttrBool("use_nesterov");
    }
  }
}
